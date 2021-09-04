package com.project.service;

import com.project.model.Product;
import com.project.util.comparator.CategoryComparator;
import com.project.util.comparator.LocationComparator;
import com.project.util.comparator.MatchCountComparator;
import com.project.util.comparator.PercentageComparator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private List<Product> filterProducts(List<Product> products, String word) {
        final List<String> words = Arrays.asList(word.split(" "));
        return products.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(words.stream().iterator().next().toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Product> criteriaMatch(List<Product> products, String word) {
        Collections.sort(products, new MatchCountComparator(word));
        return products;
    }

    private List<Product> criteriaLocation(List<Product> products, String word) {
        Collections.sort(products, new LocationComparator(word));
        return products;
    }

    private List<Product> criteriaWordPercentage(List<Product> products) {
        Collections.sort(products, new PercentageComparator());
        return products;
    }

    private List<Product> criteriaCategoryPriority(List<Product> products) {
        Collections.sort(products, new CategoryComparator());
        return products;
    }

    public List<Product> allProcesses(List<Product> products, String criteria) {
        final List<Product> filteredProducts = filterProducts(products, criteria);

        criteriaMatch(filteredProducts, criteria);

        criteriaLocation(filteredProducts, criteria);

        criteriaCategoryPriority(filteredProducts);

        criteriaWordPercentage(filteredProducts);

        return filteredProducts;
    }
}
