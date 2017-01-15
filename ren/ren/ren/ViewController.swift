//
//  ViewController.swift
//  ren
//
//  Created by Theron Patrick on 1/8/17.
//  Copyright © 2017 Theron Patrick. All rights reserved.
//

import UIKit
import AVFoundation


class ViewController: UIViewController {
    @IBOutlet var padButtons: [UIButton]!

    @IBOutlet weak var firstButton: UIButton!

    var playerArray = [AVAudioPlayer]()
    var audioArray = Array<String>()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        audioArray = readPropertyList()
        playerArray = []
        
        // Load audio players
        for i in 0...audioArray.count - 1 {
            let newPlayer: AVAudioPlayer!;
            let url = Bundle.main.url(forResource: audioArray[i], withExtension: "wav")!
            print(url)
            do {
                newPlayer = try AVAudioPlayer(contentsOf: url)
                print(newPlayer)
                playerArray.append(newPlayer)
                playerArray[i].prepareToPlay()
            } catch let error as NSError {
                print(error.description)
            }
            
        }
        
        
        // Disable buttons if we don't have sounds for them 
        for padButton in padButtons {
            if (padButton.tag > audioArray.count) {
                padButton.isUserInteractionEnabled = false
                padButton.alpha = 0.2
            }
        }

        
    }
    
    
    func readPropertyList() -> Array<String> {
        
        var myDict: NSDictionary?
        if let path = Bundle.main.path(forResource: "sounds", ofType: "plist") {
            myDict = NSDictionary(contentsOfFile: path)
        }
        if let dict = myDict {
            
            let itemsArray: Array? = dict.object(forKey: "SoundPack") as? Array<String>;
            
            return itemsArray!
        } else {
            return [];
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func padDown(_ sender: AnyObject) {
        // Tag starts at 1 because 0 indicates no tag assigned
        let index = sender.tag - 1
        
        (sender as! UIButton).backgroundColor = UIColor(red:1.00, green:0.99, blue:0.98, alpha:1.0)
        
        if (index > -1 && index < audioArray.count) {
            let player = playerArray[index];
            player.stop()
            player.currentTime = 0
            player.play()
        }
        
    }
    @IBAction func padTouchUp(_ sender: AnyObject) {
        (sender as! UIButton).backgroundColor = UIColor(netHex: 0x96A6B8)
    }

}

