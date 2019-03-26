package tn.zusammen.zusammen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tn.zusammen.zusammen.enums.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashSet;

@Document
public final class User implements UserDetails {

    @Id
    private String id;

    @NotBlank
    @Size(min = 3)
    @Indexed(unique = true)
    private String username;

    @NotBlank
    @Email
    @Indexed(unique = true)
    private String email;

    @NotNull
    @Size(min = 60, max = 60)
    private String password;

    @DBRef
    private MemberProfile memberProfile;

    @DBRef
    private PassengerProfile passengerProfile;

    @DBRef
    private LinkedHashSet<RideRequest> rideRequests;

    @DBRef
    private LinkedHashSet<RideOffer> rideOffers;

    @DBRef
    private DriverProfile driverProfile;

    @NotNull
    @Size(min = 1, max = 2, message = "User should have exactly 1 or 2 roles.")
    private EnumSet<Role> roles;

    @PersistenceConstructor
    public User(@NotBlank @Size(min = 3) final String username,
                @NotBlank @Email final String email,
                @NotNull @Size(min = 60, max = 60) final String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rideRequests = new LinkedHashSet<>();
        this.rideOffers = new LinkedHashSet<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public MemberProfile getMemberProfile() {
        return memberProfile;
    }

    public PassengerProfile getPassengerProfile() {
        return passengerProfile;
    }

    public LinkedHashSet<RideRequest> getRideRequests() {
        return rideRequests;
    }

    public LinkedHashSet<RideOffer> getRideOffers() {
        return rideOffers;
    }

    public DriverProfile getDriverProfile() {
        return driverProfile;
    }

    public EnumSet<Role> getRoles() {
        return roles;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setMemberProfile(final MemberProfile memberProfile) {
        this.memberProfile = memberProfile;
    }

    public void setPassengerProfile(final PassengerProfile passengerProfile) {
        this.passengerProfile = passengerProfile;
    }

    public void setDriverProfile(final DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public void setRoles(final EnumSet<Role> roles) {
        this.roles = roles;
    }

}
