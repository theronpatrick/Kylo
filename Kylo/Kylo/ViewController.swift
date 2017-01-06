//
//  ViewController.swift
//  kylo
//
//  Created by Theron Patrick on 1/5/17.
//  Copyright © 2017 Theron Patrick. All rights reserved.
//

import UIKit
import AVFoundation

var player: AVAudioPlayer?

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    @IBAction func onButtonTouch(_ sender: Any) {
        print("Touchy")
        print((sender as AnyObject).tag)
        
        let url = Bundle.main.url(forResource: "soundName", withExtension: "mp3")!
        
        do {
            player = try AVAudioPlayer(contentsOf: url)
            guard let player = player else { return }
            
            player.prepareToPlay()
            player.play()
        } catch let error as NSError {
            print(error.description)
        }
    }
}

