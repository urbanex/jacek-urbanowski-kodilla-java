package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User facebookGuy = new Millenials("john");
        User twitterGuy = new YGeneration("sam");
        User snapGuy = new ZGeneration("paul");
        //When
        String faceGuyUses = facebookGuy.sharePost();
        String twitterGuyUses = twitterGuy.sharePost();
        String snapGuyUses = snapGuy.sharePost();
        //Then
        Assert.assertEquals("Fejsik", faceGuyUses);
        Assert.assertEquals("Tłiter", twitterGuyUses);
        Assert.assertEquals("Snapik", snapGuyUses);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User facebookGuy = new Millenials("john");
        //When
        facebookGuy.setSocialPublisher(new TwitterPublisher());
        //Then
        Assert.assertEquals("Tłiter", facebookGuy.sharePost());
    }
}
