package com.cloudesire.vies_client.test;

import com.cloudesire.vies_client.ViesVatRegistration;
import com.cloudesire.vies_client.ViesVatService;
import com.cloudesire.vies_client.ViesVatServiceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CheckVatTest
{
    private ViesVatService service;

    @Before
    public void before()
    {
        service = new ViesVatService();
    }

    @Test
    public void test()
    {
        try
        {
            ViesVatRegistration response = service.lookup( "IT", "02103430506" );
            assertEquals( "IT", response.getCountry() );
            assertEquals( "02103430506", response.getVatNumber() );
            assertEquals( "CLOUDESIRE.COM SRL", response.getName() );
            assertEquals( "VIA ADRIANO GOZZINI 15/17 \n" + "56121 PISA PI\n", response.getAddress() );
        }
        catch ( ViesVatServiceException e )
        {
            fail( "Lookup method returned " + e.getMessage() );
        }

        try
        {
            ViesVatRegistration response = service.lookup( "DK", "26033489" );
            assertEquals( "DK", response.getCountry() );
            assertEquals( "26033489", response.getVatNumber() );
        }
        catch ( ViesVatServiceException e )
        {
            fail( "Lookup method returned " + e.getMessage() );
        }

        try
        {
            ViesVatRegistration response = service.lookup( "EL", "054934613" );
            assertEquals( "EL", response.getCountry() );
            assertEquals( "054934613", response.getVatNumber() );
        }
        catch ( ViesVatServiceException e )
        {
            fail( "Lookup method returned " + e.getMessage() );
        }
    }
}
