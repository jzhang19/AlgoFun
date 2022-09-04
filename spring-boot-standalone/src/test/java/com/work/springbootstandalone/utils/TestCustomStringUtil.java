package com.work.springbootstandalone.utils;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.work.springbootstandalone.models.Address;
import com.work.springbootstandalone.models.Household;
import com.work.springbootstandalone.models.Occupant;
import com.work.springbootstandalone.utils.customStringUtil.occupantsComparator;

public class TestCustomStringUtil {
    

    @Test
    public void testParseLine() {
        String[] expected1 = {"Dave", "Smith", "123 main st", "seattle", "wa", "43"};
        assertThat(customStringUtil.parseLine("\"Dave\",\"Smith\",\"123 main st.\",\"seattle\",\"wa\",\"43\"")).usingRecursiveComparison().isEqualTo(expected1);

        String[] expected2 = {"Dave", "Smith", "345 3rd Blvd Apt 200", "seattle", "wa", "43"};
        assertThat(customStringUtil.parseLine("\"Dave\",\"Smith\",\"345 3rd Blvd., Apt. 200\",\"seattle\",\"wa\",\"43\"")).usingRecursiveComparison().isEqualTo(expected2);

        String[] expected3 = {"Dave", "Smith", "123 main st", "seattle", "wa", "43"};
        assertThat(customStringUtil.parseLine("\"  Dave  \",\"Smith\",\"   123    main st \",\"seattle\",\"wa\",\"43\"")).usingRecursiveComparison().isEqualTo(expected3);
    }

    @Test
    public void testFormatAddress() {
        Address address = new Address("123 main st", null, "seattle", "wa", null);
        
        String expected1 = "123 main st, seattle, wa";
        assertThat(customStringUtil.formatAddress(address)).isEqualTo(expected1); 
    }

    @Test
    public void testccupantsComparator() {
        Address address = new Address("123 main st", null, "seattle", "wa", null);
        Household newHousehold = new Household(address, new ArrayList<Occupant>());
        List<Occupant> occupants = newHousehold.getOccupants();
        Occupant o1 = new Occupant("D", "Z", 20);
        occupants.add(o1);
        Occupant o2 = new Occupant("A", "Z", 20);
        occupants.add(o2);
        Occupant o3 = new Occupant("A", "B", 20);
        occupants.add(o3);
        Collections.sort(newHousehold.getOccupants(), new occupantsComparator());
        assertThat(newHousehold.getOccupants()).containsExactlyInAnyOrder(o3, o2, o1);
    }
}
