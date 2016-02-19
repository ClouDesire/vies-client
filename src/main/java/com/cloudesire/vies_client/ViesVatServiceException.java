package com.cloudesire.vies_client;

public class ViesVatServiceException extends Exception
{
	private String errorKey;

	public ViesVatServiceException ( String errorKey, String message )
	{
		super( message );
		this.errorKey = errorKey;
	}

	public ViesVatServiceException( String errorKey, String message, Throwable throwable  )
	{
		super( message, throwable );
		this.errorKey = errorKey;
	}

	public String getErrorKey ()
	{
		return errorKey;
	}
}
