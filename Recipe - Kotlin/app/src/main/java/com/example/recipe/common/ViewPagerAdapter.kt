import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

// Example: primary constructor
/* class ViewPagerAdapter constructor(
class ViewPagerAdapter(var layoutIds: List<Int>? = null): PagerAdapter() {
class ViewPagerAdapter(val layoutIds: List<Int>): PagerAdapter() { */
class ViewPagerAdapter(
    private val layoutIds: List<Int>
): PagerAdapter() {

    init {

    }

// Example: constructor
//    constructor(layoutIds: List<Int>) {
//        this.layoutIds = layoutIds
//    }

    override fun getCount(): Int {
        return layoutIds.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return container.findViewById(layoutIds[position])
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
