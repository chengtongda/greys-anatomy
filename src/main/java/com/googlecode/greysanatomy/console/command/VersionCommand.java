package com.googlecode.greysanatomy.console.command;

import com.googlecode.greysanatomy.console.command.annotation.Cmd;
import com.googlecode.greysanatomy.util.GaStringUtils;

/**
 * ����汾
 * @author vlinux
 *
 */
@Cmd("version")
public class VersionCommand extends Command {

	@Override
	public Action getAction() {
		return new Action(){

			@Override
			public void action(final Info info, final Sender sender) throws Throwable {
				sender.send(true, GaStringUtils.getLogo());
			}
			
		};
	}

}
