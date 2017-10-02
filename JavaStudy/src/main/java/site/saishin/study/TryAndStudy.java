/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package site.saishin.study;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 */
public class TryAndStudy {
    public static void main(String[] args) {
        Options options = new Options();
        try {
            CommandLine cmdline = (new DefaultParser()).parse(options, args);
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    public TryAndStudy() {
    }
    public static void tryAndStudy() {
    }
    public TryAndStudy set() {
        return null;
    }
    public static TryAndStudy singleton(String[] args) {
        Options options = new Options();
        try {
            CommandLine cmdline = (new DefaultParser()).parse(options, args);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
