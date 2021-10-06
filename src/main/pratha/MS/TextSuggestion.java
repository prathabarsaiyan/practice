package main.pratha.MS;

import java.util.*;

/**
 *
 *     Implement auto-suggest feature in a text editor.
 *
 * For any open document, if a user has already typed apple and application,
 * the next time he types 'ap', he should get suggestions for the two words matching it.
 *
 * apple
 *
 *
 * trie
 * a->p->p->l->e->EOW
 * a->p->p->l->i->c->a->t->i->o->n->EOW
 *
 *
 *
 */
public class TextSuggestion {


}

class Trie {
    TrieNode root;
    Trie(List<String> words){

    }

    public Set<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        TrieNode prefixNode = find(prefix);

        return prefixNode == null ? null :prefixNode.suggestion;
    }

    TrieNode find(String word){
        TrieNode node = root;
        int i = 0;
        while(i < word.length()){
            if(!node.children.containsKey(word.charAt(i))){
                return null;
            }
            node = node.children.get(word.charAt(i));
            i++;
        }
        return node;
    }
}


class TrieNode{
    char ch;
    boolean EOW = false;
    Set<String> suggestion ;
    Map<Character, TrieNode> children;

    TrieNode(char ch){
        this.ch = ch;
        children = new HashMap<>();
        suggestion = new HashSet<>();
    }
    //insert
    public void insert(String word, int i){
        char firstChar = word.charAt(i);
        TrieNode child ;
        if(children.containsKey(firstChar)) {
            child = children.get(firstChar);
        }else{
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }
        child.suggestion.add(word);

        if(i < word.length()-1){
            child.insert(word,i+1);
        } else {
            child.EOW = true;
        }
    }
}