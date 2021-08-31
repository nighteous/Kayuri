package net.xblacky.animexstream.ui.main.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import net.xblacky.animexstream.MainActivity
import net.xblacky.animexstream.R
import net.xblacky.animexstream.utils.preference.Preference
import net.xblacky.animexstream.utils.preference.PreferenceHelper

class Settings : Fragment(), View.OnClickListener {

    private lateinit var rootView: View
    lateinit var sharesPreference: Preference
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false)
        setOnClickListeners()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharesPreference = PreferenceHelper.sharedPreference
        setRadioButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun setOnClickListeners() {
        rootView.back.setOnClickListener(this)
    }
    private fun setRadioButtons() {
        rootView.nightModeRadioButton.isChecked = sharesPreference.getNightMode()
        rootView.nightModeRadioButton.setOnCheckedChangeListener { _, isChecked ->
            sharesPreference.setNightMode(isChecked)
            (activity as MainActivity).toggleDayNight()
        }

        rootView.pipRadioButton.isChecked = sharesPreference.getPIPMode()
        rootView.pipRadioButton.setOnCheckedChangeListener { _, isChecked ->
            sharesPreference.setPIPMode(isChecked)
        }
        rootView.googletoogle.isChecked = sharesPreference.getGoogleServer()
        rootView.googletoogle.setOnCheckedChangeListener { _, isChecked ->
            sharesPreference.setGoogleServer(isChecked)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                findNavController().popBackStack()
            }
        }
    }
}