package com.singhajit.rubygems.search;

import com.singhajit.rubygems.recent.model.Gem;

import java.util.ArrayList;

public interface GemSearchView {
  void renderResults(ArrayList<Gem> searchResults);

  void showError(String message);
}
