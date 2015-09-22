#import <AVFoundation/AVFoundation.h>
#import <Cordova/CDV.h>

@interface CDVPhone :CDVPlugin

- (void) detect:(CDVInvokedUrlCommand*)command;

@end