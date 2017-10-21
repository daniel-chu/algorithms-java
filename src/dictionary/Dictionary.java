package dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Class that stores words using a trie data structure. Only single words consisting of the 26
 * characters in the english alphabet can be stored.
 */
public class Dictionary {

  private DictNode root;

  public class DictNode {
    private char c;
    private DictNode[] children = new DictNode[26];
    private boolean isLeaf = false;

    DictNode() {
    }

    DictNode(char c) {
      this.c = c;
    }

    public void setIsLeaf(boolean isLeaf) {
      this.isLeaf = isLeaf;
    }

    public boolean hasNoChildren() {
      return Arrays.stream(children)
              .allMatch(child -> child == null);
    }
  }

  public Dictionary() {
    root = new DictNode();
  }

  // adds all words from a text file into the dictionary (text file must be one word per line)
  public void addFromFile(String fileName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String line;
      while ((line = reader.readLine()) != null) {
        this.add(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void add(String s) {
    DictNode curNode = root;
    DictNode[] children = curNode.children;
    for (int i = 0; i < s.length(); i++) {
      char curChar = Character.toLowerCase(s.charAt(i));
      int index = curChar - 'a';
      if (children[index] == null) {
        children[index] = new DictNode(curChar);
      }
      curNode = children[index];
      children = curNode.children;
    }
    if (curNode != root) {
      curNode.setIsLeaf(true);
    } else {
      throw new IllegalArgumentException("Cannot add empty string to the Dictionary.");
    }
  }

  public void remove(String s) {
    DictNode curNode = root;
    DictNode[] children = curNode.children;

    for (int i = 0; i < s.length(); i++) {
      char curChar = Character.toLowerCase(s.charAt(i));
      int index = curChar - 'a';
      if (children[index] == null) {
        return;
      } else {
        if (children[index].hasNoChildren()) {
          children[index] = null;
          return;
        } else {
          curNode = children[index];
          children = curNode.children;
        }
      }
    }
    curNode.setIsLeaf(false);
  }

  public boolean contains(String s) {
    DictNode curNode = root;
    DictNode[] children = curNode.children;
    for (int i = 0; i < s.length(); i++) {
      char curChar = Character.toLowerCase(s.charAt(i));
      int index = curChar - 'a';
      if (children[index] == null) {
        return false;
      } else {
        curNode = children[index];
        children = curNode.children;
      }
    }
    return curNode.isLeaf;
  }

}
