package com.carmedia2p0.capture.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.TextView.BufferType
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.ItemInventoryVehiclesBinding
import com.carmedia2p0.capture.model.response.getInventory.Item
import com.carmedia2p0.capture.ui.base.recyclerViewAdapter.BaseAdapter
import com.carmedia2p0.capture.ui.base.recyclerViewAdapter.DataBindingViewHolder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class InventoryVehiclesAdapter(private val context: Context) :
    BaseAdapter<Item>(
        itemsSame = { old, new -> old.id == new.id },
        contentsSame = { old, new -> old == new }
    ) {
    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_inventory_vehicles
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: DataBindingViewHolder<Item>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        val binding = holder.binding as ItemInventoryVehiclesBinding

        val builder = SpannableStringBuilder()

        val year = item.year
        val yearSpannable = SpannableString(year)
        yearSpannable.setSpan(ForegroundColorSpan(context.getColor(R.color.very_light_pink)), 0, year.length, 0)
        builder.append(yearSpannable)
        builder.append(" ")

        val make = item.make
        val makeSpannable = SpannableString(make)
        makeSpannable.setSpan(ForegroundColorSpan(context.getColor(R.color.very_light_pink)), 0, make.length, 0)
        builder.append(makeSpannable)
        builder.append(" ")

        val model = item.model
        val modelSpannable = SpannableString(model)
        modelSpannable.setSpan(ForegroundColorSpan(context.getColor(R.color.bluey_grey)), 0, model.length, 0)
        builder.append(modelSpannable)

        binding.headingText.setText(builder, BufferType.SPANNABLE)
        binding.vinData.text = String.format(context.getString(R.string.vin) + " " + item.vin)
        binding.stockData.text = String.format(context.getString(R.string.stock) + " " + item.stockNumber)
        binding.status.text = String.format(item.mediaStatus)
        binding.subHeadingText.text = String.format(item.trim)

        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        val date: Date = dateFormat.parse(item.dateCreated)!!
        val dateDifference = printTimeDifference(date, Calendar.getInstance().time) {
            binding.missingMediaData.setTextColor(if (it) context.getColor(R.color.red_brown) else context.getColor(R.color.new_yellow))
        }
        binding.missingMediaData.text = dateDifference
    }

    private fun printTimeDifference(startDate: Date, endDate: Date, colorManipulate: (Boolean) -> Unit): String {

        var different = endDate.time - startDate.time

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different %= daysInMilli
        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli
        val elapsedMinutes = different / minutesInMilli
        colorManipulate(elapsedDays >= 2 && elapsedHours >= 0 && elapsedMinutes> 0)
        return (
            "${elapsedDays}d ${elapsedHours}h ${elapsedMinutes}m"
            )
    }
}
