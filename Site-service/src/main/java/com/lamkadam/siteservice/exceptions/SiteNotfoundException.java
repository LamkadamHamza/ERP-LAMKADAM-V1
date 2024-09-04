package com.lamkadam.siteservice.exceptions;

import org.apache.logging.log4j.message.Message;

public class SiteNotfoundException extends Exception{

    public SiteNotfoundException (String message){ super(message); }
}
