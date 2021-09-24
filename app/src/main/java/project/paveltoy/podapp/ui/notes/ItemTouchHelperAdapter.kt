package project.paveltoy.podapp.ui.notes

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemSwipe(position: Int)
}