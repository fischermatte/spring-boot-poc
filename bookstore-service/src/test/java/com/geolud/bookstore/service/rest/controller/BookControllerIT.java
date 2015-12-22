package com.geolud.bookstore.service.rest.controller;

import com.geolud.bookstore.service.books.service.api.BookData;
import com.geolud.bookstore.service.test.BookstoreIntegrationTest;
import com.geolud.bookstore.service.test.TestBaseUrl;
import com.geolud.bookstore.service.test.TestDataInitializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@BookstoreIntegrationTest
public class BookControllerIT {
    @Autowired
    private TestBaseUrl baseUrl;
    @Autowired
    private TestDataInitializer dataInitializer;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp() throws Exception {
        dataInitializer.insertBook("Die Räuber 1", "123", "Friedrich", "Schiller");
        dataInitializer.insertBook("Die Räuber 3", "345", "Friedrich", "Schiller");
        dataInitializer.insertBook("Die Räuber 2", "234", "Friedrich", "Schiller");
        dataInitializer.insertBook("Faust", "456", "Johann Wolfgang", "Goethe");
    }

    @Test
    public void searchByTitle() {
        ResponseEntity<BookData[]> response = restTemplate.getForEntity(
                baseUrl + "/books/search?title=räuBer",
                BookData[].class);
        BookData[] books = response.getBody();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("123", books[0].getIsbn());
        Assert.assertEquals("234", books[1].getIsbn());
        Assert.assertEquals("345", books[2].getIsbn());
    }

}