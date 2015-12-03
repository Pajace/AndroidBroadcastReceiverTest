package com.logdown.mycodetub.testbroadcastreceiver.receiver;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.logdown.mycodetub.testbroadcastreceiver.TestContext;

import junit.framework.TestCase;

import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Created by Pajace on 2015/12/3.
 */
public class MySecretReceiverTest extends TestCase {
    private MySecretReceiver mReceiver;
    private TestContext mContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mReceiver = new MySecretReceiver();
        mContext = new TestContext();
    }

    public void testStartActivity_verifyCount() {
        // Arrange
        Intent intentMock = Mockito.mock(Intent.class);
        when(intentMock.getAction()).thenReturn(MySecretReceiver.ACTION_MY_TEST_SECRET_INTENT);
        when(intentMock.getStringExtra(MySecretReceiver.KEY_OF_SECRET_TEST_NUMBER))
                .thenReturn("01234567890");
        int expectedReceiveIntentCount = 1;

        // Act
        mReceiver.onReceive(mContext, intentMock);
        int actualReceiveIntentCount = mContext.getReceivedIntents().size();

        // Accert
        assertEquals(expectedReceiveIntentCount, actualReceiveIntentCount);
        assertNull(mReceiver.getResultData());

        Intent receivedIntent = mContext.getReceivedIntents().get(0);
        assertNull(receivedIntent.getAction());
        assertEquals("01234567890", receivedIntent.getStringExtra("phoneNum"));
        assertTrue((receivedIntent.getFlags() & Intent.FLAG_ACTIVITY_NEW_TASK) != 0);
    }

    public void testStartActivity_verifyReceivedIntent() {
        // Arrange
        String expectedSecretNumber = "01234567890";
        Intent intent = new Intent("com.logdown.mycodetub.test.secret");
        intent.putExtra(MySecretReceiver.KEY_OF_SECRET_TEST_NUMBER, expectedSecretNumber);

        // Act
        mReceiver.onReceive(mContext, intent);
        Intent receivedIntent = mContext.getReceivedIntents().get(0);
        String actualSecretNumber = receivedIntent.getStringExtra(MySecretReceiver.KEY_OF_SECRET_TEST_NUMBER);

        // Assert
        assertNull(receivedIntent.getAction());
        assertEquals(expectedSecretNumber, actualSecretNumber);
        assertTrue((receivedIntent.getFlags() & Intent.FLAG_ACTIVITY_NEW_TASK) != 0);
    }
}