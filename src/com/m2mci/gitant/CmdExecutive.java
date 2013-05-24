package com.m2mci.gitant;

import java.io.IOException;
import java.util.List;

/**
 * Execute a given command via the runtime.exec and return success or failure.
 *
 * @author mike
 *
 * <p>------------------------------------- NOTICE -----------------------------------------<br/>
 * <p>Copyright &copy 2013 M2M Connections Inc..  All rights reserved.</p>
 * 
 * <p>Redistribution and use in source and binary forms, with or
 *    without modification, are permitted provided that the
 *    following conditions are met:</p>
 * 
 * <p>1.  Redistributions of source code must retain the above
 *        copyright notice, this list of conditions and the
 *        following disclaimer.
 *     
 * <p>2.  Redistributions in binary form must reproduce the above
 *        copyright notice, this list of conditions and the following
 *        disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *     
 * <p>3.  The end-user documentation included with the redistribution
 *        if any, must include the following acknowledgment:
 *          "This product includes software developed by M2M Connections
 *           Inc. (http://www.m2mconnectionsinc.com)."
 *        Alternately, this acknowledgment may appear in the software itself,
 *        if and wherever such third-party acknowledgments normally appear.
 *     
 * <p>4.  The name M2M Connections Inc. must NOT be used to endorse or promote
 *        products derived from this software with prior written permission.
 *        Contact info@m2mconnectionsinc.com
 *     
 * <p>5.  Products derived from this software may not be called
 *        "M2M Connections" nor may "M2M Connections" appear in their name,
 *        without prior written permission from M2M Connections Inc.
 * 
 * <p>THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE. 
 * <p>------------------------------------- NOTICE -----------------------------------------<br />
 */
public class CmdExecutive {
	private String command = null;
	
	public CmdExecutive( final String cmd ) {
		command = cmd;
	}
	
	/**
	 * Run the command the instance of the CmdExecutive was initialized with.
	 * @param results : List<String> - a collection of String to which any result information will be added.
	 * @return Boolean - True if the command executed successfully, false otherwise.
	 */
	public Boolean run( List<String> results ) {
		if( null == command ) {
			results.add( "null command provided.  Stopping." );
			return Boolean.FALSE;
		}
		
		try {
			Process p = Runtime.getRuntime().exec( command );
			p.waitFor();
			Integer result = Integer.valueOf( p.exitValue() );
			results.add( result.toString() );
			return Boolean.TRUE;
		} catch( IOException e ) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}
}
