package com.example.lab7

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TicketDetailFragmentTest {

    @Test
    fun testCheckBoxAndEditTextUpdateTicket() {
        // Launch the fragment in a test container
        val scenario = launchFragmentInContainer<TicketDetailFragment>()

        // Test that EditText (ticketTitle) is displayed and type text into it
        onView(withId(R.id.ticketTitle))
            .check(matches(isDisplayed()))
            .perform(typeText("Test Ticket Title"), closeSoftKeyboard())

        // Test that CheckBox (ticketSolved) is displayed and check it
        onView(withId(R.id.ticketSolved))
            .check(matches(isDisplayed()))
            .perform(click())

        // Verify that the fragment's Ticket object is updated correctly
        scenario.onFragment { fragment ->
            val viewModel = fragment.ticketDetailViewModel

            viewModel.ticket.observe(fragment.viewLifecycleOwner) { ticket ->
                assert(ticket?.title == "Test Ticket Title") { "Title did not update!" }
                assert(ticket?.isSolved == true) { "CheckBox did not update!" }
            }
        }
    }
}