//
//  ViewController.swift
//  iOSclassAss
//
//  Created by kasutaja on 12/03/15.
//  Copyright (c) 2015 kasutaja. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var txtName: UITextField!
    @IBOutlet weak var txtPasword: UITextField!
    @IBOutlet weak var lblWrong: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func btnLoginClick(sender: AnyObject) {
        if (txtName.text=="name" && txtPasword.text=="password")
        {
             //txtName.text="Sended";
            performSegueWithIdentifier("Screen2",sender:self)
        }
        else
        {
            lblWrong.text="Wrong user name or password";
        }
       
    }
    
    
    }


class UIViewControlerScene2:UIViewController{
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}