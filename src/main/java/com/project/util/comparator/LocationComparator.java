package com.project.util.comparator;

import com.project.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@AllArgsConstructor
@Data
public class LocationComparator implements Comparator<Product>  {

    private String value;

    @Override
    public int compare(Product p1, Product p2) {

        String[] split1 = p1.getTitle().split(" ");
        String[] split2 = p2.getTitle().split(" ");

        int location1 = 0;
        int location2 = 0;

        for (int i = 0; i < split1.length; i++) {
            if (split1[i].equals(value)) {
                location1 = i;
                break;
            }
        }

        for (int i = 0; i < split2.length; i++) {
            if (split2[i].equals(value)) {
                location2 = i;
                break;
            }
        }

        if (location1 > location2) {
            return 1;
        } else if (location2 > location1) {
            return -1;
        } else
            return 0;
    }

}
