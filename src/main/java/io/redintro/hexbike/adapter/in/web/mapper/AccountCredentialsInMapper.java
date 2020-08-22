package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.AccountCredentialsResource;
import io.redintro.hexbike.domain.AccountCredentials;

public class AccountCredentialsInMapper {
        public static AccountCredentials mapToDomainEntity(AccountCredentialsResource accountCredentialsResource) {
        return new AccountCredentials(
                accountCredentialsResource.getUsername(),
                accountCredentialsResource.getPassword());
    }

    public static AccountCredentialsResource mapToResource(AccountCredentials accountCredentials) {
        return new AccountCredentialsResource(
                accountCredentials.getUsername(),
                accountCredentials.getPassword());
    }
}
