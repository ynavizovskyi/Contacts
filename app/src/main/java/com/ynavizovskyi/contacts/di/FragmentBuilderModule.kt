package com.ynavizovskyi.contacts.di

import com.ynavizovskyi.contacts.presentation.contactlist.ContactListFragment
import com.ynavizovskyi.contacts.presentation.ContactDetailsFragment
import com.ynavizovskyi.contacts.presentation.EditContactFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindSignInFragment(): ContactListFragment?

    @ContributesAndroidInjector
    abstract fun bindDetailsFragment(): ContactDetailsFragment?

    @ContributesAndroidInjector
    abstract fun bindEditFragment(): EditContactFragment?

}