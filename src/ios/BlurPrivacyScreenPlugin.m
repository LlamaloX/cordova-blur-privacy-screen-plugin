/**
 * BlurPrivacyScreenPlugin.m
 * Created by s3rious a.k.a Leonid Semenov on 09/09/2019
 * Copyright (c) 2019 s3rious a.k.a Leonid Semenov. All rights reserved.
 * MIT Licensed
 */

#import "AppDelegate.h"

#define BLUR_VIEW_TAG 7331
#define ANIMATION_SPEED 0.35f

@interface AppDelegate (BlurPrivacyScreen) {}

@end

@implementation AppDelegate (BlurPrivacyScreen)

// On before app become disabled
- (void)applicationWillResignActive:(UIApplication *)application
{
    // Get window
    const UIWindow *window = self.window;
    
    // Set it's background color
    window.backgroundColor = [UIColor clearColor];
    
    // Crate new view with blurEfferct applied to it
    UIBlurEffect *blurEffect = [UIBlurEffect effectWithStyle:UIBlurEffectStyleRegular];
    UIVisualEffectView *blurView = [[UIVisualEffectView alloc] initWithEffect:blurEffect];
    
    // Set view options
    blurView.tag = BLUR_VIEW_TAG;
    blurView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    blurView.frame = window.bounds;
    blurView.alpha = 0;
    
    // Add it to the view, bring to the front
    [blurView setFrame:window.frame];
    [window bringSubviewToFront:blurView];
    [window addSubview:blurView];
    
    // Animate to 1.0 alpha
    [UIView animateWithDuration:ANIMATION_SPEED animations:^{
        [blurView setAlpha:1];
    }];
}

// On app active
- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Get window and blur view
    const UIWindow *window = self.window;
    UIView *view = [window viewWithTag:BLUR_VIEW_TAG];
    
    // It it's present then…
    if (view != nil)
    {
        // …animate to alpha 0…
        [UIView animateWithDuration:ANIMATION_SPEED animations:^{
            [view setAlpha:0];
        } completion:^(BOOL finished) {
            // …and then remove
            [view removeFromSuperview];
        }];
    }
}

@end
