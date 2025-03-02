package org.PageObjectManager;




public class PageObjectManager {
	
	private createAccountElements createAccount_elements;
	private siginAccountElements sign_In_elements;


	public createAccountElements createAccount_elements() {
		return (createAccount_elements==null) ? createAccount_elements = new createAccountElements() : createAccount_elements;

	}
	
	public siginAccountElements sign_In_elements() {
		return (sign_In_elements==null) ? sign_In_elements = new siginAccountElements() : sign_In_elements;

	}

	
}


