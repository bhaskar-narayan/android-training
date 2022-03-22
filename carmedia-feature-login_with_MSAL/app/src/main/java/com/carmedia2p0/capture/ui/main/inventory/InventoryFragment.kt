package com.carmedia2p0.capture.ui.main.inventory

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.adapters.FilterKeysAdapter
import com.carmedia2p0.capture.adapters.InventoryVehiclesAdapter
import com.carmedia2p0.capture.databinding.InventoryFragmentBinding
import com.carmedia2p0.capture.model.dummy.DummyKeyFilterResponse
import com.carmedia2p0.capture.ui.base.fragment.BaseFragment
import com.carmedia2p0.capture.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InventoryFragment : BaseFragment<InventoryFragmentBinding, InventoryViewModel>(R.layout.inventory_fragment) {

    private val mViewModel: InventoryViewModel by viewModels()
    private val activityViewModel: MainViewModel by activityViewModels()
    private lateinit var filterKeysAdapter: FilterKeysAdapter
    private lateinit var inventoryVehiclesAdapter: InventoryVehiclesAdapter

    override fun onInitDataBinding(viewBinding: InventoryFragmentBinding) {
        setupRecyclerView(viewBinding)
        populateDummyFilterKeys()
        subscribeToLiveData()

        with(viewBinding) {
            toolbarFilterSortLayout.setOnItemClick {
                when (it.id) {
                    R.id.sortButton -> {
                        toolbarFilterSortLayout.setAscending = true
                    }
                    R.id.filterButton -> {
//                        toolbarFilterSortLayout.setFilter = true
                    }
                }
            }
        }
    }

    override fun getViewModel(): InventoryViewModel {
        return mViewModel
    }

    private fun subscribeToLiveData() {
        mViewModel.inventoryLiveData.observe(viewLifecycleOwner) {
            inventoryVehiclesAdapter.submitList(it.toList())
        }
    }

    private fun populateDummyFilterKeys() {
        val filterResponseFirst = DummyKeyFilterResponse("Not Started")
        val filterResponseSecond = DummyKeyFilterResponse("BMW")
        val filterResponseThird = DummyKeyFilterResponse("Black")
        val filterResponseForth = DummyKeyFilterResponse("CPO")
        val filterResponseFifth = DummyKeyFilterResponse("Green")

        val filterKeys = arrayListOf(filterResponseFirst, filterResponseSecond, filterResponseThird, filterResponseForth, filterResponseFifth)
        filterKeysAdapter.submitList(filterKeys)
    }

    private fun setupRecyclerView(viewBinding: InventoryFragmentBinding) {
        filterKeysAdapter = FilterKeysAdapter {
        }
        inventoryVehiclesAdapter = InventoryVehiclesAdapter(requireContext())
        viewBinding.filterKeysRecycleView.apply {
            adapter = filterKeysAdapter
        }
        viewBinding.vehiclesRecycleView.apply {
            adapter = inventoryVehiclesAdapter
        }
    }
}
