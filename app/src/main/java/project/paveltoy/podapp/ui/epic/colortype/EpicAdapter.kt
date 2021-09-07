package project.paveltoy.podapp.ui.epic.colortype

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class EpicAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    var fragmentSet: List<Fragment> = listOf()

    override fun getItemCount(): Int {
        return fragmentSet.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentSet[position]
    }
}