package com.project.util.comparator;

import com.project.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class MatchCountComparator implements Comparator<Product> {

    private String value;

    @Override
    public int compare(Product p1, Product p2) {

        String[] values = value.split(" ");

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < values.length; i++) {
            if(p1.getTitle().compareToIgnoreCase(values[i])>0) {
                count1++;
            }
        }

        for (int i = 0; i < values.length; i++) {
            if(p2.getTitle().compareToIgnoreCase(values[i])>0) {
                count2++;
            }
        }

        if (count1 > count2) {
            return 1;
        } else if (count2 > count1) {
            return -1;
        } else {
            return firstWordMatch(p1, p2);

        }
    }

    private int firstWordMatch(Product p1, Product p2) {
        String[] values = value.split(" ");

        if (p1.getTitle().compareToIgnoreCase(values[0])>0) {
            return 1;
        } else if (p2.getTitle().compareToIgnoreCase(values[0])>0) {
            return -1;
        } else
            return 0;
    }
}
