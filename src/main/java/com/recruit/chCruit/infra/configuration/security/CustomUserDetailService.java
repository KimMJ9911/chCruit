package com.recruit.chCruit.infra.configuration.security;

import com.recruit.chCruit.infra.entity.memberPackage.Member;
import com.recruit.chCruit.infra.persistance.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByEmail(email);

        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(member.getMemberStatus().getMemberRole().toString())
        );

        return new User(member.getEmail(), member.getPassword(), authorities);
    }
}
