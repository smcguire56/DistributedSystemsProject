package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements Service {

	private static final long serialVersionUID = 1L;
	
	protected ServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String create(String s) throws RemoteException {
		return null;
	}

	@Override
	public void read() throws RemoteException {
		System.out.println("read test");
	}

	@Override
	public String update(String s) throws RemoteException {
		return null;
	}

	@Override
	public String delete(String s) throws RemoteException {
		return null;
	}

}
