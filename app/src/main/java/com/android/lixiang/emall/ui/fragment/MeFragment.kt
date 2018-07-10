package com.android.lixiang.emall.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import com.android.lixiang.emall.R
import com.android.lixiang.emall.ui.adapter.MeFunctionAdapter
import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.SizeUtils
import kotlinx.android.synthetic.main.fragment_me.*


class MeFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            mOrderBtn -> {
                
            }
        }
    }

    var iconList: MutableList<Int>? = mutableListOf()
    var titleList: MutableList<Int>? = mutableListOf()
    var userName = String()
    var ME_USERNAME_CODE = 100
    var toast: Toast? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iconList!!.add(R.drawable.img_me_list_1)
        iconList!!.add(R.drawable.img_me_list_2)
        iconList!!.add(R.drawable.img_me_list_6)
        iconList!!.add(R.drawable.img_me_list_3)
        iconList!!.add(R.drawable.img_me_list_4)
        iconList!!.add(R.drawable.img_me_list_5)

        titleList!!.add(R.string.favourite)
        titleList!!.add(R.string.ticket)
        titleList!!.add(R.string.bill)
        titleList!!.add(R.string.setting)
        titleList!!.add(R.string.contact_us)
        titleList!!.add(R.string.suggestion)


//        me_function_lv.adapter = MeFunctionAdapter(iconList, titleList, context)
        mMeListView.adapter = MeFunctionAdapter(iconList, titleList, context)

        val screenHeight = activity!!.application.resources.displayMetrics.heightPixels.toFloat()//1440
        if (screenHeight - SizeUtils.getMeasuredHeight(me_ll) > 0) {
            val rl = RelativeLayout(activity)
            val rlParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, (screenHeight - SizeUtils.getMeasuredHeight(me_ll)).toInt())
            rl.layoutParams = rlParams
            rl.setBackgroundColor(Color.parseColor("#F0F0F0"))
            me_ll.addView(rl, rlParams)
        }

        mOrderBtn.setOnClickListener(this)
//        mOrderBtn.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else
//                toOrderDelegate(0)
//        }
//
//        me_avatar_iv.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else {
//                if (DatabaseManager().getInstance()!!.getDao()!!.loadAll().isEmpty()) {
//                    val delegate: SignInByTelDelegate = SignInByTelDelegate().create()!!
//                    val bundle = Bundle()
//                    bundle.putString("PAGE_FROM", "ME")
//                    delegate.arguments = bundle
//                    DELEGATE!!.startForResult(delegate, ME_USERNAME_CODE)
//                }
//            }
//        }
//
//        me_fake_btn.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else {
//                if (DatabaseManager().getInstance()!!.getDao()!!.loadAll().isEmpty()) {
//                    val delegate: SignInByTelDelegate = SignInByTelDelegate().create()!!
//                    val bundle = Bundle()
//                    bundle.putString("PAGE_FROM", "ME")
//                    delegate.arguments = bundle
//                    DELEGATE!!.startForResult(delegate, ME_USERNAME_CODE)
//                }
//            }
//        }
//
//
//
//        me_function_lv.setOnItemClickListener { adapterView, view, i, l ->
//            when (i) {
//                0 -> {
//                    if (!NetworkUtils.isConnected())
//                        if (toast != null) {
//                            toast!!.setText(getString(R.string.no_internet))
//                            toast!!.duration = Toast.LENGTH_SHORT
//                            toast!!.show()
//                        } else {
//                            toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                            toast!!.show()
//                        }
//                    else {
//                        if (!DatabaseManager().getInstance()!!.getDao()!!.loadAll().isEmpty()) {
//                            (DELEGATE as EcBottomDelegate).start(CollectionDelegate().create())
//                        } else {
//                            val delegate: SignInByTelDelegate = SignInByTelDelegate().create()!!
//                            val bundle = Bundle()
//                            bundle.putString("PAGE_FROM", "ME")
//                            delegate.arguments = bundle
//                            (DELEGATE as EcBottomDelegate).start(delegate)
//                        }
//                    }
//                }
//                1 -> {
//                    if (!NetworkUtils.isConnected())
//                        if (toast != null) {
//                            toast!!.setText(getString(R.string.no_internet))
//                            toast!!.duration = Toast.LENGTH_SHORT
//                            toast!!.show()
//                        } else {
//                            toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                            toast!!.show()
//                        }
//                    else {
//                        if (!DatabaseManager().getInstance()!!.getDao()!!.loadAll().isEmpty()) {
//                            (DELEGATE as EcBottomDelegate).start(CouponDelegate().create())
//                        } else {
//                            val delegate: SignInByTelDelegate = SignInByTelDelegate().create()!!
//                            val bundle = Bundle()
//                            bundle.putString("PAGE_FROM", "ME")
//                            delegate.arguments = bundle
//                            (DELEGATE as EcBottomDelegate).start(delegate)
//                        }
//                    }
//                }
//                2 -> {
//                    if (!NetworkUtils.isConnected())
//                        if (toast != null) {
//                            toast!!.setText(getString(R.string.no_internet))
//                            toast!!.duration = Toast.LENGTH_SHORT
//                            toast!!.show()
//                        } else {
//                            toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                            toast!!.show()
//                        }
//                    else {
//                        if (DatabaseManager().getInstance()!!.getDao()!!.loadAll().isEmpty()) {
//                            val delegate: SignInByTelDelegate = SignInByTelDelegate().create()!!
//                            val bundle = Bundle()
//                            bundle.putString("PAGE_FROM", "ME")
//                            delegate.arguments = bundle
//                            (DELEGATE as EcBottomDelegate).start(delegate)
//                        } else {
//                            val delegate: InvoiceDelegate = InvoiceDelegate().create()!!
//                            val bundle: Bundle? = Bundle()
//                            bundle!!.putString("INVOICE_PRICE", "-")
//                            delegate.arguments = bundle
//                            (DELEGATE as EcBottomDelegate).start(delegate)
//                        }
//                    }
//                }
//                3 -> {
//                    if (!NetworkUtils.isConnected())
//                        if (toast != null) {
//                            toast!!.setText(getString(R.string.no_internet))
//                            toast!!.duration = Toast.LENGTH_SHORT
//                            toast!!.show()
//                        } else {
//                            toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                            toast!!.show()
//                        }
//                    else
//                        (DELEGATE as EcBottomDelegate).start(SettingDelegate().create())
//                }
//                4 -> {
//                    if (!NetworkUtils.isConnected())
//                        if (toast != null) {
//                            toast!!.setText(getString(R.string.no_internet))
//                            toast!!.duration = Toast.LENGTH_SHORT
//                            toast!!.show()
//                        } else {
//                            toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                            toast!!.show()
//                        }
//                    else
//                        (DELEGATE as EcBottomDelegate).start(ContactDelegate().create())
//                }
//                5 -> {
//                    if (!NetworkUtils.isConnected())
//                        if (toast != null) {
//                            toast!!.setText(getString(R.string.no_internet))
//                            toast!!.duration = Toast.LENGTH_SHORT
//                            toast!!.show()
//                        } else {
//                            toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                            toast!!.show()
//                        }
//                    else
//                        (DELEGATE as EcBottomDelegate).start(FeedbackDelegate().create())
//                }
//            }
//        }
//
//        btn1.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else
//
//                toOrderDelegate(1)
//        }
//
//        btn2.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else
//                toOrderDelegate(2)
//        }
//
//        btn3.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else
//                toOrderDelegate(3)
//        }
//
//        btn4.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else
//                toOrderDelegate(4)
//        }
//
//        me_to_computer_iv.setOnClickListener {
//            if (!NetworkUtils.isConnected())
//                if (toast != null) {
//                    toast!!.setText(getString(R.string.no_internet))
//                    toast!!.duration = Toast.LENGTH_SHORT
//                    toast!!.show()
//                } else {
//                    toast = Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT)
//                    toast!!.show()
//                }
//            else{
//                val delegate: ScannerDelegate = ScannerDelegate().create()!!
//                val bundle: Bundle? = Bundle()
//                bundle!!.putString("PAGE_FROM", "ME")
//                delegate.arguments = bundle
//                (DELEGATE as EcBottomDelegate).start(delegate)
//            }
//        }
    }
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

//    fun toOrderDelegate(index: Int) {
//        if (DatabaseManager().getInstance()!!.getDao()!!.loadAll().isEmpty()) {
//            val delegate: SignInByTelDelegate = SignInByTelDelegate().create()!!
//            val bundle = Bundle()
//            bundle.putString("PAGE_FROM", "ME")
//            delegate.arguments = bundle
//            (DELEGATE as EcBottomDelegate).start(delegate)
//        } else {
//            val delegate: OrderListDelegate = OrderListDelegate().create()!!
//            val bundle: Bundle? = Bundle()
//            bundle!!.putString("USER_ID", DatabaseManager().getInstance()!!.getDao()!!.loadAll()[0].userId)
//            bundle.putInt("INDEX", index)
//            bundle.putString("PAGE_FROM", "ME")
//            delegate.arguments = bundle
//            (DELEGATE as EcBottomDelegate).start(delegate)
//
//        }
//    }
//
//
//    override fun onSupportVisible() {
//        super.onSupportVisible()
////        val list: List<UserProfile>? = DatabaseManager().getInstance()!!.getDao()!!.loadAll()
////        EmallLogger.d("google_lenve", "search: " + list!![0].username)
//        activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//
//        if (!DatabaseManager().getInstance()!!.getDao()!!.loadAll().isEmpty()) {
//            userName = DatabaseManager().getInstance()!!.getDao()!!.loadAll()[0].username
//
//            if (userName != "") {
//                me_user_name.text = userName
//                me_hint.text = getString(R.string.me_hint)
//            }
//            me_to_computer_iv.visibility = View.VISIBLE
//        } else {
//            me_user_name.text = getString(R.string.sign_in)
//            me_hint.text = getString(R.string.click_to_login)
//            me_to_computer_iv.visibility = View.GONE
//        }
//    }
}

