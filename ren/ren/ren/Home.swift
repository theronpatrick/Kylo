//
//  Home.swift
//  ren
//
//  Created by Theron Patrick on 1/10/17.
//  Copyright © 2017 Theron Patrick. All rights reserved.
//

import UIKit
import AVFoundation


class Home: UINavigationController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        print("things happened")
        
        readPropertyList()
    }
    
    func readPropertyList(){
        
        var myDict: NSDictionary?
        if let path = Bundle.main.path(forResource: "sounds", ofType: "plist") {
            myDict = NSDictionary(contentsOfFile: path)
        }
        if let dict = myDict {
            // Use your dict here
            print ("dict is ")
            print(dict)
        }
    }

    
    
}

