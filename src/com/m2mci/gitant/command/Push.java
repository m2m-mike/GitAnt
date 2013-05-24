package com.m2mci.gitant.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;

import com.m2mci.gitant.CmdExecutive;

/**
 * Implementation of the Git push command for the GitAnt framework.
 * Simply pushes a specific tag to the origin.
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
public class Push extends GitCommand {
	
	private String repository = null;
	private String tag = null;

	@Override
	protected void exeCmd() {
		List<String> results = new ArrayList<String>();
		StringBuffer cmd = new StringBuffer( "git" );
		
		if( null != repository ) {
			cmd.append( " --git-dir=" );
			cmd.append( repository );
			cmd.append( "/.git" );
		}
		
		cmd.append( " push origin " );
		
		if( null != tag ) {
			cmd.append( tag );
		}
		
		System.out.println( cmd.toString() );
		
		CmdExecutive runner = new CmdExecutive( cmd.toString() );
		if( !runner.run( results ) ) {
			throw new BuildException( results.get( 0 ) );
		}
		System.out.println( "resutls: " + results.get( 0 ) );

	}
	
	public void setRepo( final String repo ) {
		repository = repo;
	}
	
	public void setTag( final String tag ) {
		this.tag = tag;
	}

}
