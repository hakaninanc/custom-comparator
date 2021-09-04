package com.project.util.comparator;

import com.project.model.Product;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {

        Integer priority1 = p1.getCategory().getPriority();
        Integer priority2 = p2.getCategory().getPriority();

        if (priority1 > priority2) {
            return 1;
        } else if (priority2 > priority1) {
            return -1;
        } else
            return 0;

    }
}
