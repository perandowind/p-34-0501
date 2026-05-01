package com.back.global.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class SecurityUser(
    val id: Int,
    username: String,
    password: String,
    val nickname: String,
    authorities: MutableCollection<out GrantedAuthority>
) : User(username, password, authorities)
