//
//  ViewController.swift
//  ren
//
//  Created by Theron Patrick on 1/8/17.
//  Copyright © 2017 Theron Patrick. All rights reserved.
//

import UIKit

class HomeController: UIViewController {

    @IBOutlet weak var subtitle: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let title = readPropertyList()
        subtitle.setTitle(title,for: .normal)
    }
    
    func readPropertyList() -> String {
        
        var myDict: NSDictionary?
        if let path = Bundle.main.path(forResource: "sounds", ofType: "plist") {
            myDict = NSDictionary(contentsOfFile: path)
        }
        if let dict = myDict {
            // Use your dict here
            print ("dict is ")
            
            return (dict.object(forKey: "SoundPackName") as? String)!;
            
        } else {
            return "";
        }
    }
}

