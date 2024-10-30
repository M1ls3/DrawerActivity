    package com.example.draweractivity.ui.NewActivity.ui.main

    import android.content.Intent
    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Button
    import android.widget.TextView
    import androidx.fragment.app.Fragment
    import androidx.lifecycle.Observer
    import androidx.lifecycle.ViewModelProvider
    import com.example.draweractivity.MainActivity
    import com.example.draweractivity.R
    import com.example.draweractivity.databinding.FragmentMainBinding

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        private lateinit var pageViewModel: PageViewModel
        private var _binding: FragmentMainBinding? = null

        // This property is only valid between onCreateView and
        // onDestroyView.
        private val binding get() = _binding!!

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
                setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
            }
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            _binding = FragmentMainBinding.inflate(inflater, container, false)
            val root = binding.root

            val textView: TextView = binding.sectionLabel
            pageViewModel.text.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })

            val activityButton: Button = binding.activityButton
            activityButton.setOnClickListener {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent) }

            if (arguments?.getInt(ARG_SECTION_NUMBER) == 1 || arguments?.getInt(ARG_SECTION_NUMBER) == 2)
                activityButton.visibility = View.INVISIBLE

            return root
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private const val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            @JvmStatic
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                return PlaceholderFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_SECTION_NUMBER, sectionNumber)
                    }
                }
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }