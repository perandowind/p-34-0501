package com.back.domain.member.entity

import com.back.global.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import lombok.NoArgsConstructor
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.List

@Entity
@NoArgsConstructor
class Member(
    @Column(unique = true)
    var username: String,
    var password: String,
    var nickname: String,
    @Column(unique = true)
    var apiKey: String
) : BaseEntity() {


    constructor(id: Int, username: String, nickname: String)
            : this(username, "", nickname, "") {
        this.setId(id)
        this.username = username
        this.nickname = nickname
    }

    val name: String
        get() = this.username

    val isAdmin: Boolean
        get() = "admin" == username

    val authorities: MutableList<SimpleGrantedAuthority>
        get() {
            if (this.isAdmin) {
                return List.of<SimpleGrantedAuthority>(SimpleGrantedAuthority("ROLE_ADMIN"))
            } else {
                return List.of<SimpleGrantedAuthority>(SimpleGrantedAuthority("ROLE_USER"))
            }
        }
}
