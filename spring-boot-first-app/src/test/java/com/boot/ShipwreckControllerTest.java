package com.boot;

import com.boot.controllers.ShipwreckController;
import com.boot.models.Shipwreck;
import com.boot.repositories.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        Mockito.when(shipwreckRepository.findOne(1L)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);

        Mockito.verify(shipwreckRepository).findOne(1L);
        assertEquals(wreck.getId().longValue(), 1L);
    }

    @Test
    public void testShipwreckGetHamcrest() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        Mockito.when(shipwreckRepository.findOne(1L)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);

        Mockito.verify(shipwreckRepository).findOne(1L);
        assertThat(wreck.getId(), is(1L));
    }
}
