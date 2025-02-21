package com.salihakbas.cvmaker.data.repository

import com.salihakbas.cvmaker.data.source.local.MainDao
import com.salihakbas.cvmaker.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDao: MainDao,
) : MainRepository