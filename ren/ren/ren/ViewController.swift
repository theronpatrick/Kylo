//
//  ViewController.swift
//  ren
//
//  Created by Theron Patrick on 1/8/17.
//  Copyright © 2017 Theron Patrick. All rights reserved.
//

import UIKit
import AVFoundation

internal var audioArray: Array = [
    "bass 1",
    "bass 2",
    "kick1",
    "rip 1",
    "shake 1",
    "snare 1"
]

internal var playerArray = [AVAudioPlayer]()

class ViewController: UIViewController {

    @IBOutlet weak var firstButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
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

