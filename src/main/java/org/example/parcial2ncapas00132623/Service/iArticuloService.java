package org.example.parcial2ncapas00132623.Service;


import org.example.parcial2ncapas00132623.Model.DTOs.Requests.MagicArticleRequestDTO;
import org.example.parcial2ncapas00132623.Model.MagicArticle;
import org.example.parcial2ncapas00132623.Model.MagicProvider;


public interface iArticuloService {
    MagicArticle createArticulo(MagicArticleRequestDTO request);
    MagicProvider updateArticulo(Long id, MagicArticleRequestDTO request);
    void deleteArticulo(Long id);
}
