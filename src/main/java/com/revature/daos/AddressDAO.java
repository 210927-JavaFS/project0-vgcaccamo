package com.revature.daos;

import com.revature.models.Address;

public interface AddressDAO {
    Address findByAddress(Address address);

    Address findById(int id);

    boolean addAddress(Address address);
}
