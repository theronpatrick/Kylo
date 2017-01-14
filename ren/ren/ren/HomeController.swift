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
    @IBOutlet weak var titleButton: UIButton!
    @IBOutlet weak var youtubeImage: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let buttonTitle = readPropertyList()
        subtitle.setTitle(buttonTitle, for: .normal)
        
        let tap = UITapGestureRecognizer(target: self, action: #selector(self.handleTap(_:)))
        
        self.view.addGestureRecognizer(tap)
        
        let tap2 = UITapGestureRecognizer(target: self, action: #selector(self.handleTap(_:)))
        
        subtitle.addGestureRecognizer(tap2)
        
        let tap3 = UITapGestureRecognizer(target: self, action: #selector(self.handleTap(_:)))
        
        titleButton.addGestureRecognizer(tap3)
        
        let tap4 = UITapGestureRecognizer(target: self, action: #selector(self.goToYoutube(_:)))
        
        youtubeImage.addGestureRecognizer(tap4)
        
        
    }
    
    func handleTap(_ sender: UITapGestureRecognizer) {
        
        print("derp")

        performSegue(withIdentifier: "padSegue", sender: nil)
    }
    
    func goToYoutube(_ sender: UITapGestureRecognizer) {
        
        print("youtube")
        
        let url  = NSURL(string: "https://youtube.com/channel/UCNRFvq0JOm5VqHIBDDQgkMA")
        
        if UIApplication.shared.canOpenURL(url! as URL) == true  {
            UIApplication.shared.open(url! as URL)
        }

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

