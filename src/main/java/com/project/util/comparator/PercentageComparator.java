package com.project.util.comparator;

import com.project.model.Product;

import java.util.Comparator;

public class PercentageComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {

        String[] split1 = p1.getTitle().split(" ");
        String[] split2 = p2.getTitle().split(" ");

        if (split1.length > split2.length) {
            return 1;
        } else if (split2.length > split1.length) {
            return -1;
        } else
            return 0;
    }
}
