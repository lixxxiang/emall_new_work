package com.android.lixiang.emall.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.lixiang.classify.ui.activity.OpticsActivity
import com.android.lixiang.emall.R
import kotlinx.android.synthetic.main.fragment_classify.*
import org.jetbrains.anko.support.v4.startActivity

class ClassifyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classify, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn.setOnClickListener {
            startActivity<OpticsActivity>()
        }

        btn2.setOnClickListener {
            startActivity<OpticsActivity>()
        }
    }
}
