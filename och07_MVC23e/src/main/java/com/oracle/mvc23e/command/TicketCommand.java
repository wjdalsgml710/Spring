package com.oracle.mvc23e.command;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.oracle.mvc23e.dao.TicketDao;
import com.oracle.mvc23e.dto.TicketDto;

public class TicketCommand implements ITicketCommand {

	
	private TicketDao 			ticketDao;
	private TransactionTemplate TransactionTemplate2;
	
	
	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}



	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		TransactionTemplate2 = transactionTemplate2;
	}

	public TicketDao getTicketDao() {
		return ticketDao;
	}



	public TransactionTemplate getTransactionTemplate2() {
		return TransactionTemplate2;
	}

	// Service
	@Override
	public void execute(final TicketDto ticketDto) {
		// TODO Auto-generated method stub
		TransactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				ticketDto.setAmount("1");
				ticketDao.buyTicket(ticketDto);
				
				ticketDto.setAmount("3");
				ticketDao.buyTicket(ticketDto);
			}
		}
	  );
	}

}
