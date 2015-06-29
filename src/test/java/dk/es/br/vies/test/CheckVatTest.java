package dk.es.br.vies.test;

import dk.es.br.vies.ViesVatRegistration;
import dk.es.br.vies.ViesVatService;
import dk.es.br.vies.ViesVatServiceException;
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
		} catch ( ViesVatServiceException e )
		{
			fail( "Lookup method returned " + e.getMessage() );
		}
	}
}
