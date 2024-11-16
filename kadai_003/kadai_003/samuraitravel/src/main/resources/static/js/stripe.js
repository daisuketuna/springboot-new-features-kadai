const stripe = Stripe('pk_test_51Q9M9fD3g0tYePWjWc0jYPBX9aqBdEKWhP5tZVA6aZQmqbbJNUNxXq74sZHEGuEWS3AloeckPwCIqY1XbIxPSmeB008fXjjN5x');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
});